import React from "react";
import { useState } from "react";
import { useNavigate } from "react-router-dom";
import { toast } from "react-toastify";
import config from "../../config";
import axios from "axios";
import Navbar from "../../components/Navbar";


const Product = () => {

    const [productName, setProductName] = useState('');
    const [productImage1, setProductImage] = useState(null);
    const [productDescription, setProductDescription] = useState('');
    const [productPrice, setProductPrice] = useState('');
    const [productStatus, setProductStatus] = useState('');
    const [productQuantity, setProductQuantity] = useState('');


    const config1 = { headers: { 'Content-Type': 'multipart/form-data' } };

    // this function is used to navigate from one component to another programmatically
    // userNavigate() returns a function reference
    const navigate = useNavigate()

    const uploadProduct = () => {                              //this is a function for onClick event on Signup Button
        console.log(productName)
        if (productName.length === 0) {
            //alert('enter firstname');                  //Old way to display
            toast.error('please enter product name')
        } else if (productImage1.length === null) {
            toast.error('please upload product')
        } else if (productDescription.length === 0) {
            toast.error('please enter product description')
        } else if (productPrice.length === 0) {
            toast.error('please enter product price ')
        } else if (productStatus.length === 0) {
            toast.error('please enter product status')
        } else if (productQuantity.length === 0) {
            toast.error('please enter product quantity')
        } else {
            // make the API call to check if user exists
            axios
                .post(config.serverURL + '/product/uploadProduct', {
                    productName,
                    productImage1,
                    productDescription,
                    productPrice,
                    productStatus,
                    productQuantity,
                },config1)
                .then((response) => {
                    // get the data returned by server
                    const result = response.data

                    // check if user's authentication is successfull
                    if (result['status'] === 'error') {
                        toast.error('invalid email or password')
                    } else {
                        toast.success('successfully Uploaded Image')

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
                            <p className="fs-3 text-center">Product Upload</p>
                            
                            <div className="mb-3">
                                <label className="form-label">Product Name</label>
                                <input onChange={(event) => {
                                    setProductName(event.target.value)
                                }}
                                    type="text"
                                    class="form-control" />
                            </div>
                            
                            <div className="mb-3">
                                <label className="form-label">Product Image</label> <input
                                    onChange={(event) => {
                                        setProductImage(event.target.files[0])
                                    }}
                                    type="file"
                                    className="form-control" />
                            </div>
                            
                            <div className="mb-3">
                                <label className="form-label">Product Description</label> <input onChange={(event) => {
                                    setProductDescription(event.target.value)
                                }}
                                    type="text"
                                    className="form-control" />
                            </div>

                            <div className="mb-3">
                                <label className="form-label">Product Price</label> <input onChange={(event) => {
                                    setProductPrice(event.target.value)
                                }}
                                    type="text" className="form-control" />
                            </div>

                            <div className="mb-3">
                                <label className="form-label">Status</label> <input
                                    onChange={(event) => {
                                        setProductStatus(event.target.value)
                                    }}
                                    type="text" className="form-control" />
                            </div>

                            <div className="mb-3">
                                <label className="form-label">Quantity</label> <input onChange={(event) => {
                                    setProductQuantity(event.target.value)
                                }}
                                    type="text" className="form-control" />
                            </div>


                            <button type="submit" onClick={uploadProduct} className="btn btn-primary offset-md-5">Upload Product</button>
                        </div>
                    </div>
                </div>

            </div>
        </div>
    </div>
}

export default Product;