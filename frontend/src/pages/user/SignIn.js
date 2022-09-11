import Navbar from "../../components/Navbar";
import React from "react";
import { toast } from "react-toastify";
import axios from "axios";
import { useState } from "react";
import { useNavigate } from "react-router-dom";
import config from "../../config";

const SignIn = () => {

    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');

    const navigate = useNavigate();

    const signin=()=>{                           //this is a function for onClick event on Signup Button
        
            if (email.length === 0) {
                toast.error('please enter email')
            } else if (password.length === 0) {
                toast.error('please enter password')
            } else {
                // make the API call to check if user exists
                axios
                    .post(config.serverURL + '/user/loginUser', {
                        email,         
                        password,
                    })
                    .then((response) => {
                        // get the data returned by server
                        const result = response.data
    
                        // check if user's authentication is successfull
                        if (result['status'] === 'error') {
                            toast.error('invalid email or password')
                        } else {
                            toast.success('successfully login')
    
                            // navigate to the singin page
                            navigate('/')
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
        <div className="container p-5">
            <div className="row">
                <div className="col-md-4 offset-md-4">
                    <div className="card paint-card">
                        <div className="card-body">
                            <p className="fs-4 text-center">User Login</p>
                                <div className="mb-3">
                                    <label className="form-label">Email address</label> <input onChange={(event) => {
                                    setEmail(event.target.value)
                                }}  type="email" className="form-control"  />
                                </div>

                                <div class="mb-3">
                                    <label className="form-label">Password</label> <input  onChange={(event) => {
                                    setPassword(event.target.value)
                                }}
                                type="password" className="form-control" />
                                </div>

                                <button type="submit"  onClick={signin} className="btn bg-success text-white col-md-12">Login</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
}

export default SignIn;