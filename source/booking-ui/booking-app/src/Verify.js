import React from "react"
import './Verify.css'
import './User.css'
import axios from 'axios'
import ResetPwd from "./ResetPwd"

class Verify extends React.Component{

    constructor(props){
        super(props)
        this.state={
            securityqn:"",
            answer:"",
            check:""
        }
    }
    handleClick= event=>{
        event.preventDefault()
        // axios.get(`http://localhost:8081/user`+this.props.item.name)
        // .then(res=>{
        //     console.log("res"+res)
        // })
        let path5=`/resetPassword`
        console.log(this.props.answer)
        console.log(this.state.answer)
        if(this.props.securityqn===this.state.securityqn && this.props.answer===this.state.answer)
        {
            
           // this.props.history.push(path5)
           this.setState({
               check:"yes"
           })
        }
        else if(this.props.securityqn!=this.state.securityqn){
            console.log("security question is incorrect")
            alert("security question is incorrect")
            
        }
        else if(this.props.answer!=this.state.answer){
            console.log("Answer is incorrect")
            alert("Answer is incorrect")
        }
    }
    handleChange = event => {

        const { name, value } = event.target
        this.setState({
            [name]: value
        })

    }

    render(){
        return(
            <div>
            <form onSubmit={this.handleClick} className="form5">
                    <div className="container2">
                        {console.log(this.props)}
                   {console.log(this.props.location)}
                   <label><b>Security Question</b></label>
                    <select
                            value={this.state.securityqn}
                            onChange={this.handleChange}
                            name="securityqn"
                        >
                            <option value="sq">--Select a Security Question--</option>   
                            <option value="color">what is your fav color?</option>
                            <option value="movie">what is your fav movie?</option>
                            <option value="pet">what is your fav pet?</option>
                            <option value="hero">who is your fav hero?</option>
                        </select>
                        <br></br>
                        <br></br>
                        <label><b>Answer</b></label>
                        <input type="text" placeholder="Enter Answer" value={this.state.answer} name="answer" onChange={this.handleChange} required />        
                        <button type="submit">Next</button>
               
                
                    </div>
                </form>
                
                {console.log(this.props.name)}
                    
                   {!this.state.check?null:<ResetPwd key={this.props._id} name={this.props.name}/>}
                </div>
        )
    }
}

export default Verify