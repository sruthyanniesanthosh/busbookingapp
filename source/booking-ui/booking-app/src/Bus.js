import React from "react"
import './BusList.css'
import BookSeats from "./BookSeats";

class Bus extends React.Component{

    constructor(props){
        super(props);
        this.state={
            y:""
        }
    }
    seatOptions() {
        var arr = [];

        for (let i = 1; i <= 40; i++) {
            arr.push(<option key={i} value="{i}">{i}</option>)
        }

        return arr; 
    }
    handleSubmit=event=>{
        this.setState({
            y:"yes"
        })

    }
   
    renderTableData() {
           return (
              <tr key={this.props.item._id} id="data">

                 <td>BusName:{this.props.item.busName}</td>
                 <td>Source:{this.props.item.source}</td>
                 <td>Destination:{this.props.item.destination}</td>
                <td>price:{this.props.item.price}</td>
                <td>travelDate:{this.props.travelDate}</td>
                <td><button type="submit" onClick={this.handleSubmit}>Book Now</button></td>
              </tr>
           )
        }

    render(){

        return(
            <div>
                <table id="table">
                    <tbody id="tablebody">
                        {this.renderTableData()}        
                    </tbody>
                </table>
            {console.log(this.state.y)}
                {this.state.y!=="yes"?null: <BookSeats travelDate={this.props.travelDate} key={this.props.item._id} id={this.props.item._id}/>}
                
                
            </div>
        )
}

}
export default Bus
