/**
 * User Block
 */
import React, { Component } from 'react';

class UserBlock extends Component {
    render() {
        return (
            <div className="profile-top mb-20">
                <img src={require('Assets/img/finalprofile.png')} alt="profile banner" className="img-fluid" width="1920" height="345" />
                <div className="profile-content">
                    <div className="media">
                    <ul className="list-inline d-flex align-content-center">
                        <li className="list-inline-item col">
                            <ul className="list-inline d-flex align-content-center">
                                <li className="list-inline-item col">
                                    <img src={require('Assets/avatars/profile.jpg')} alt="user profile" className="rounded-circle mr-25 bordered" width="150" height="150" />
                                </li>
                            </ul>

                        </li>
                    </ul>
                        
                        <div className="media-body pt-25">
                            <div className="mb-20">

                                <h2>{localStorage.getItem("nombreuser")}</h2>
                                <p>{localStorage.getItem("emailuser")}</p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        );
    }
}

export default UserBlock;
