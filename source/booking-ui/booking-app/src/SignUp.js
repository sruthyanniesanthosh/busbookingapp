import React from 'react';
import axios from 'axios';
import './SignUp.css'

class SignUp extends React.Component {

    state = {
        name: "",
        password: "",
        firstName: "",
        lastName: "",
        email: "",
        securityqn: "",
        answer: ""

    }


    handleChange = event => {
        const { name, value } = event.target
        this.setState({
            [name]: value
        })
    }

    handleSubmit = event => {
        event.preventDefault();
        alert("submitted Successfully");
        console.log(this.state)
        let path1 = `signIn`
        this.props.history.push(path1)
        axios.post(`http://localhost:8081/user`, this.state)
            .then(res => {
                console.log(res);

            })


    }

    handleClick = event => {
        event.preventDefault();
        let path = ``
        this.props.history.push(path)

    }
    render() {
        return (
            <div>
                <form onSubmit={this.handleSubmit} className="reg">
                    <div className="container">
                        <label><b>Name</b></label>
                        <input type="text" placeholder="Enter Name" name="name" value={this.state.name} onChange={this.handleChange} required />
                        <label><b>First Name</b></label>
                        <input type="text" placeholder="Enter FirstName" name="firstName" value={this.state.firstName} onChange={this.handleChange} required />
                        <label><b>Last Name</b></label>
                        <input type="text" placeholder="Enter LastName" name="lastName" value={this.state.lastName} onChange={this.handleChange} required />
                        <label><b>Email</b></label>
                        <input type="text" placeholder="Enter Email" name="email" value={this.state.email} onChange={this.handleChange} required />
                        <label><b>Password</b></label>
                        <input type="password" placeholder="Enter Password" name="password" value={this.state.password} onChange={this.handleChange} required />
                        <label><b>Security Question</b></label>
                        <select
                            value={this.state.securityqn}
                            onChange={this.handleChange}
                            name="securityqn"
                        >
                            <option name="" value="sq">--Select a Security Question--</option>   
                            <option name="" value="coor">what is your fav color?</option>
                            <option value="movie">what is your fav movie?</option>
                            <option value="pet">what is your fav pet?</option>
                            <option value="hero">who is your fav hero?</option>
                        </select><br></br><br></br>
                        <label><b>Answer</b></label>
                        <input type="text" placeholder="Enter Answer" name="answer" value={this.state.answer} onChange={this.handleChange} required/>
                        <div className="clearfix">
                            <button type="button" onClick={this.handleClick} className="cancelbtn">Cancel</button>
                            <button type="submit" className="signupbtn">Sign Up</button>
                        </div>
                    </div>
                </form>
            </div>
        )
    }
}

export default SignUp