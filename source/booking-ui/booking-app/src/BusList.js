import React from 'react'
import './BusList.css'
import Bus from './Bus'
import axios from 'axios';

class BusList extends React.Component {
   constructor(props) {
      super(props);
      this.state = { //state is by default an object
         source: "",
         destination: "",
         travelDate:"",
         details:[]
      
      }
      this.handleSubmit = this.handleSubmit.bind(this);
      this.handleClick= this.handleClick.bind(this);
      this.handleChange=this.handleChange.bind(this);
      this.handleDate=this.handleDate.bind(this);

   }
   handleSubmit(event) {
      event.preventDefault()
      axios.get(`http://localhost:8081/bus?source=`+this.state.source+`&destination=`+this.state.destination)
          .then(res => {
             this.setState({
                details:res.data
             })
            console.log("details"+this.state.details)
          })
   }
   handleChange=event=>{
      const{name,value}=event.target
      this.setState({
         [name]: value
      })
      
   }

   handleClick()
   {
      this.props.history.push('/profile')
   }

   handleDate(event){
      const{name,value}=event.target
      this.setState({
         [name]:value.toLocaleString()
      })
   }

   render() {

      const busDetails=this.state.details.map(item=><Bus key={item._id} item={item} travelDate={this.state.travelDate}/>)
      return (
         <div>
            <form onSubmit={this.handleSubmit}>
            <button onClick={this.handleClick} style={{width:"100px"}}>Profile</button><br/>
            <input type="text" id="ip" placeholder="Source" name="source" value={this.state.source} onChange={this.handleChange} />
            <input type="text" id="ip" placeholder="Destination" name="destination" value={this.state.destination} onChange={this.handleChange} />
            <input type="date" id="ip" value={this.state.travelDate} name="travelDate" onChange={this.handleDate} />
            <button id="ip" >Search</button>
            {busDetails}
            </form>
            
            
         </div>
      )
   }

}
export default BusList