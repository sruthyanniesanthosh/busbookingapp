import React from 'react'
import './BusList.css'
import Bus from './Bus'
import axios from 'axios';

class BusList extends React.Component {
   constructor() {
      super();
      this.state = { //state is by default an object
         source: "",
         destination: "",
         details:[]
      
      }
      this.handleSubmit = this.handleSubmit.bind(this);
   }
   handleSubmit(event) {
      event.preventDefault()
      console.log(this.state.source)
      console.log(this.state.destination)
      axios.get(`http://localhost:8081/bus?source=`+this.state.source+`&destination=`+this.state.destination)
          .then(res => {
             this.setState({
                details:res.data
             })
            
          })
   }
   handleChange=event=>{
      const{name,value}=event.target
      this.setState({
         [name]: value
      })
      
   }

   render() {

      const busDetails=this.state.details.map(item=><Bus key={item._id} item={item}/>)
      return (
         <div>
            <form onSubmit={this.handleSubmit}>
            <input type="text" id="ip" placeholder="Source" name="source" value={this.state.source} onChange={this.handleChange} />
            <input type="text" id="ip" placeholder="Destination" name="destination" value={this.state.destination} onChange={this.handleChange} />
            <input type="date" id="ip" />
            <button id="ip">Search</button>
            {busDetails}
            </form>
            
         </div>
      )
   }

}
export default BusList