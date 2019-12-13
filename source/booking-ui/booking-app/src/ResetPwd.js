import React from 'react';
import axios from 'axios';
import './SignUp.css'
import { hashHistory } from 'react-router';

class ResetPwd extends React.Component {

    state = {
        password: "",
        rePassword:"",
        val:""
    }


    handleChange = event => {
        const { name, value } = event.target
        this.setState({
            [name]: value
        })
    }

    handleSubmit = event => {
        event.preventDefault();
        // alert("submitted Successfully");
        // console.log(this.state)
        
        if(this.state.password === this.state.rePassword)
        {
            const pwd={
                "password":this.state.password
            }
            axios.put(`http://localhost:8081/forgot/`+this.props.name,pwd)
            .then(res => {
                console.log(res);
                this.setState({
                    val:"Yes"
                })
                // hashHistory.push('./signIn')
            })
            
        }
       


    }

    handleClick = event => {
        const {name,value}=event.target
        this.setState({
            [name]:value
        })

    }
    render() {
        return (
            <div>
                <form onSubmit={this.handleSubmit} className="reg">
                    <div className="container">
                        <label><b>Password</b></label>
                        <input type="password" placeholder="Enter Password" name="password" value={this.state.password} onChange={this.handleChange} required />
                        <label><b>Re-Password</b></label>
                        <input type="password" placeholder="ReEnter Password" name="rePassword" value={this.state.rePassword} onChange={this.handleChange} required />
                        <div className="clearfix">
                            <button type="submit" className="signupbtn">Sign Up</button>
                        </div>
                    </div>
                </form>
               
            </div>
        )
    }
}

export default ResetPwd