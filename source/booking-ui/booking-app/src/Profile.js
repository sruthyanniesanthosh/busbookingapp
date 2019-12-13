import React from 'react' ;
import axios from 'axios';
import Booking from './Booking'

    class Profile extends React.Component 
    {
        constructor()
        {
            super();
            this.state={
                details:[]
            }

        }

        componentDidMount()
        {
            axios.get(`http://localhost:8081/book/`+sessionStorage.getItem('username'))
            .then(res => {
                console.log(res)
               this.setState({
                   
                  details:res.data
               })
              console.log("details"+this.state.details)
            })
        }


        
        render()
        {
            const bookingDetails=this.state.details.map(item=><Booking key={item._id} item={item}/>)
            return (
                <div>

                   <h3> Bookings </h3>
                   <div>
                    {bookingDetails}
                    </div>

                </div>
            )

        }



    }

    export default Profile;