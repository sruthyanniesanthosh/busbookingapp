import React from 'react'
import './User.css'
import Verify from './Verify'
import axios from 'axios';

class User extends React.Component {
   constructor() {
      super();
      this.state = { //state is by default an object
         name:"",
         usrDetails:{}
      
      }
      this.handleClick = this.handleClick.bind(this);
   }
   handleClick(event) {
      event.preventDefault()

      axios.get(`http://localhost:8081/user/`+this.state.name)
          .then(response => {
             this.setState({
                usrDetails:response.data
             })
            
            })
            
            //  console.log("name"+response.data.name)
            console.log("details"+this.state.usrDetails.name)
         
          
      //     let path3='/verify'
      //   this.props.history.push(path3)
   }
   handleChange=event=>{
      const{name,value}=event.target
      this.setState({
         [name]: value
      })
      
   }

   render() {

      
      return (
         <div>
            <form onSubmit={this.handleClick} className="form4">
                
                <div className="container2">
                    <label><b>UserName</b></label>
                    <input type="text" placeholder="Enter Username" value={this.state.name} name="name" onChange={this.handleChange} required />        
                     <button type="submit">Next</button>
                    {/* {userData} */}
                </div>
            </form>
            {!this.state.usrDetails.name? null:<Verify key={this.state.usrDetails._id} securityqn={this.state.usrDetails.securityqn} name={this.state.usrDetails.name} answer={this.state.usrDetails.answer}/>}
            {console.log(this.state.usrDetails.name)}
            
         </div>
      )
      
   }

}
export default User