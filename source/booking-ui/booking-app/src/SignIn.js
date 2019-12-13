import React, { Component } from 'react';
import './SignIn.css';
import axios from 'axios'

class SignIn extends Component {
    state = {
        name: "",
        password: ""
    }
    handleClick = event => {
        event.preventDefault()
        let encrypt = {
            headers: {
                Authorization:
                    "Basic " + btoa(this.state.name + ":" + this.state.password)
            }
        };
        let path1 = `/busList`

        axios.post("http://localhost:8081/user/auth", "", encrypt)
            .then(response => {
                console.log(response.status);
                if (response.status === 200) {
                    this.props.history.push(path1)
                }
                else {
                    alert("username or password incorrect")
                }
                //   localStorage.setItem(response)

            }).catch(error=> {
                alert("username or password incorrect")
                console.log(error);
            });

    }
    handleChange = event => {

        const { name, value } = event.target
        this.setState({
            [name]: value
        })

    }

    render() {
        return (
            <div>
                <form onSubmit={this.handleClick} className="form1">
                    <div className="container2">
                        <label><b>Username</b></label>
                        <input type="text" placeholder="Enter Username" value={this.state.name} name="name" onChange={this.handleChange} required />
                        <label><b>Password</b></label>
                        <input type="password" placeholder="Enter Password" value={this.state.password} name="password" onChange={this.handleChange} required />
                        <button type="submit">Login</button>

                    </div>
                    <div className="container">
                        <span className="psw"><a href="/signUp">Register?</a></span>
                        <span className="rg"><a href="/user">Forgot password?</a></span>
                    </div>
                </form>
            </div>


        );
    }
}

export default SignIn;