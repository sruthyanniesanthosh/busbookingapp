import React from 'react'
import './BookSeats.css'
import axios from 'axios';
class BookSeats extends React.Component{
  
        constructor() {
          super();
            this.state = {
               status:false,
               seatNo:"",
            seat: [
              'S1','S2','S3','S4','S5','S6','S7','S8','S9',
              'S10','S11','S12','S13','S14','S15','S16',
              'S17','S18','S19','S20','S21','S22','S23','S24','S25','S26','S27','S28','S29','S30'
            ],
            seatAvailable: [
                'S1','S2','S3','S4','S5','S6','S7','S8','S9',
                'S10','S11','S12','S13','S14','S15','S16',
                'S17','S18','S19','S20','S21','S22','S23','S24','S25','S26','S27','S28','S29','S30'
            ],
            seatReserved: [],
            booked:"",
          }
          this.onClickData=this.onClickData.bind(this)
          this._onSubmit=this._onSubmit.bind(this)
          this.onClickSeat=this.onClickSeat.bind(this)

        }
        _onSubmit= event=>{
            this.BookDetails={
                "userName":sessionStorage.getItem('username'),
                "seatNo":this.state.seatNo,
                "date":this.props.travelDate
            }
            console.log(this.BookDetails)
            axios.post(`http://localhost:8081/book/`+this.props.id,this.BookDetails)
            .then(res=>{
                console.log(res.data)
                if(res.data.status==="Success"){
                    alert("Booked Successfully");
                }
                else{
                    alert("Seat is already reserved.Try some other seats");   
                }
            })

        }
        onClickSeat(seat) {
            console.log(seat)
            this.setState({
                seatNo:seat
            })
            
            this.onClickData(seat);
        
          }
        onClickData(seat) {
          if(this.state.seatReserved.indexOf(seat) > -1 ) {
            this.setState({
              seatAvailable: this.state.seatAvailable.concat(seat),
              seatReserved: this.state.seatReserved.filter(res => res !== seat)
            })
          } else {
            this.setState({
              seatReserved: this.state.seatReserved.concat(seat),
              seatAvailable: this.state.seatAvailable.filter(res => res !== seat)
            })
          }
        }
        
        render() {
            const {status}=this.state
            const textDisplay = status? 'Booking Done':'Confirm booking'
            
          return (
            <div>
              <h1>Seat Reservation</h1>
                <div className="container">
              <table className="grid">
                <tbody>
                    <tr>
                      { this.state.seat.map( row =>
                        <td 
                          className={this.state.seatReserved.indexOf(row) }
                          key={row} onClick = {e => this.onClickSeat(row)}>
                              {row}
                               </td>) }
                    </tr>
                </tbody>
              </table>
              
              
              <div className="right">
              <h4>Reserved Seats: ({this.state.seatReserved.length})</h4>
              <ul>
                { this.state.seatReserved.map(res => <li key={res} >{res}</li>) }
              </ul>
          
            </div>
             </div>
                <button onClick={()=>this._onSubmit()}>{textDisplay}</button>
            </div>
          )
        }
      }
      
     
    
     
export default BookSeats