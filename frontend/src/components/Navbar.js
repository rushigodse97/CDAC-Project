import { Link } from "react-router-dom";
import React from "react";
const Navbar = () => {
    return <div>
        <nav className="navbar navbar-expand-lg navbar-dark bg-success">
            <button className="navbar-toggler" type="button" data-bs-toggle="collapse"
                data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
                aria-expanded="false" aria-label="Toggle navigation">
                <span className="navbar-toggler-icon"></span>
            </button>

            <div className="collapse navbar-collapse" >
                <Link className="navbar-brand" to="/home">Woodworks.com</Link>
                <ul className="navbar-nav mr-auto mt-2 mt-lg-0">

                    <li className="nav-item">
                        <Link className="nav-link active" aria-current="page" to="/home">HOME</Link>
                    </li>
                    <li className="nav-item">
                        <Link className="nav-link active" aria-current="page" to="/SignIn">SignIn</Link>
                    </li>
                    <li>
                        <Link className="nav-link active" aria-current="page" to="/">SignUp</Link>
                    </li>

                    <li class="nav-item">
                        <a className="nav-link active" aria-current="page" href="AdminLogin.jsp">ADMIN</a>
                    </li>

                </ul>
            </div>

        </nav>
    </div>
}

export default Navbar;