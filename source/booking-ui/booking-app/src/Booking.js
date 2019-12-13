import React from 'react';

class Booking extends React.Component{

    constructor(props){
        super(props);
       
    }
    renderTableData() {

           return (
              <tr key={this.props.item._id} id="data">
                  {console.log(this.props)}
                 <td>Booking Id:{this.props.item.busId}</td>
                 <td>Source:{this.props.item.source}</td>
                 <td>Destination:{this.props.item.destination}</td>
                
                <td>Seat Number : {this.props.item.seatNo} </td>
           <td>Travel Date : { this.props.item.travelDate} </td>
                
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
            </div>
        )
}
}
export default Booking;

