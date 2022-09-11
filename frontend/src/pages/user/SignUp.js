import Navbar from "../../components/Navbar";
import { useState } from "react";
import React from "react";
import axios from 'axios';
import { ToastContainer, toast } from 'react-toastify';
import config from "../../config";
import { useNavigate } from "react-router-dom";

const SignUp = () => {

    const [firstname, setFirstname] = useState('');
    const [lastname, setLastname] = useState('');
    const [mobileNo, setMobileNo] = useState('');
    const [email, setEmail] = useState('');
    const [role, setRole] = useState('');
    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');

    // this function is used to navigate from one component to another programmatically
    // userNavigate() returns a function reference
    const navigate = useNavigate()

    const signup = () => {                              //this is a function for onClick event on Signup Button
        console.log(firstname)
        if (firstname.length === 0) {
            //alert('enter firstname');                  //Old way to display
            toast.error('please enter first name')
        } else if (lastname.length === 0) {
            toast.error('please enter last name')
        } else if (email.length === 0) {
            toast.error('please enter email')
        } else if (mobileNo.length === 0) {
            toast.error('please enter phone number')
        } else if (role.length === 0) {
            toast.error('please enter role')
        } else if (username.length === 0) {
            toast.error('please enter username')
        } else if (password.length === 0) {
            toast.error('please enter password')
        } else {
            // make the API call to check if user exists
            axios
                .post(config.serverURL + '/user/registerUser', {
                    firstname,
                    lastname,
                    email,
                    mobileNo,
                    username,
                    password,
                    role,
                })
                .then((response) => {
                    // get the data returned by server
                    const result = response.data

                    // check if user's authentication is successfull
                    if (result['status'] === 'error') {
                        toast.error('invalid email or password')
                    } else {
                        toast.success('successfully registered a new user')

                        // navigate to the singin page
                        navigate('/signin')
                    }
                })
                .catch((error) => {
                    console.log('error')
                    console.log(error)
                })
        }
    }
    return <div>
        <Navbar />
        <div className="container-fluid p-3">
            <div className="row">

                <div className="col-md-5 offset-md-4">
                    <div className="card paint-card">
                        <div className="card-body">
                            <p className="fs-3 text-center">Register User</p>

                            <div className="mb-3">
                                <label className="form-label">First Name</label>
                                <input onChange={(event) => {
                                    setFirstname(event.target.value)
                                }}
                                    type="text"
                                    class="form-control" />
                            </div>

                            <div className="mb-3">
                                <label className="form-label">Last Name</label> <input
                                    onChange={(event) => {
                                        setLastname(event.target.value)
                                    }}
                                    type="text"
                                    className="form-control" />
                            </div>

                            <div className="mb-3">
                                <label className="form-label">Mobile Number</label> <input onChange={(event) => {
                                    setMobileNo(event.target.value)
                                }}
                                    type="text"
                                    className="form-control" />
                            </div>

                            <div className="mb-3">
                                <label className="form-label">Email</label> <input onChange={(event) => {
                                    setEmail(event.target.value)
                                }}
                                    type="email" className="form-control" />
                            </div>

                            <div className="mb-3">
                                <label className="form-label">Role</label> <input
                                    onChange={(event) => {
                                        setRole(event.target.value)
                                    }}
                                    type="text" className="form-control" />
                            </div>

                            <div className="mb-3">
                                <label className="form-label">Username</label> <input onChange={(event) => {
                                    setUsername(event.target.value)
                                }}
                                    type="text" className="form-control" />
                            </div>

                            <div className="mb-3">
                                <label className="form-label">Password</label> <input onChange={(event) => {
                                    setPassword(event.target.value)
                                }}
                                    type="password" className="form-control" />
                            </div>


                            <button type="submit" onClick={signup} className="btn btn-primary offset-md-5">Signup</button>
                        </div>
                    </div>
                </div>


            </div>
        </div>
    </div>
}


export default SignUp;