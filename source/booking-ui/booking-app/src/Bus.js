import React from "react"
import './BusList.css'

class Bus extends React.Component{

    constructor(props){
        super(props);
       
    }
    renderTableData() {

           return (
              <tr key={this.props.item._id} id="data">
                  {console.log(this.props)}
                 <td>BusName:{this.props.item.busName}</td>
                 <td>Source:{this.props.item.source}</td>
                 <td>Destination:{this.props.item.destination}</td>
                <td>price:{this.props.item.price}</td>
                <td><button>Book now</button></td>
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
export default Bus
