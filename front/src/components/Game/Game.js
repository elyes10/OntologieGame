import React, {useEffect, useState} from 'react';
import {blue} from "@mui/material/colors";
import offcanvas from "bootstrap/js/src/offcanvas";

function Game() {
    const [equipments, setEquipments] = useState([]);
    const [gname, setGname] = useState("");
    function refresh() {
        const url = 'http://localhost:8080/API/games';//api url
        fetch(url).then(resp => resp.json())//calling url by method GET
            .then(resp => setEquipments(resp))//setting response to state overtime
            .catch(e => console.log('There is an issue with getting the information' , e))
    }
    function online() {
        const url = 'http://localhost:8080/API/online';//api url
        fetch(url).then(resp => resp.json())//calling url by method GET
            .then(resp => setEquipments(resp))//setting response to state overtime
            .catch(e => console.log('There is an issue with getting the information' , e))
    }
    function ofline() {
        const url = 'http://localhost:8080/API/ofline';//api url
        fetch(url).then(resp => resp.json())//calling url by method GET
            .then(resp => setEquipments(resp))//setting response to state overtime
            .catch(e => console.log('There is an issue with getting the information' , e))
    }
    function game(gname) {
        const url = `http://localhost:8080/API/game/${gname}`;//api url
        fetch(url).then(resp => resp.json())//calling url by method GET
            .then(resp => setEquipments(resp))//setting response to state overtime
            .catch(e => console.log('There is an issue with getting the information' , e))
    }

    useEffect(()=>{refresh()},[]);
    return (
        <div>
            <h1 style={{color:"darkblue"}}>Games</h1>
<div>
            <input type="text" placeholder="Game Name" style={{marginLeft:"10px"}}
                   onChange={(e) => {
                       setGname(e.target.value)
                   }}/>
    <button type="button" class="btn btn-outline-dark" onClick={()=>game(gname)}>Search</button>
</div>
            <br/>
            <button type="button" className="btn btn-outline-danger" onClick={() => refresh()}>All Games</button> &nbsp;
            <button type="button" className="btn btn-outline-primary" onClick={() => online()}>Online Games</button> &nbsp;
            <button type="button" className="btn btn-outline-warning" onClick={() => ofline()}>Offline Games</button>
            <table className="table">
                <thead className="thead-dark">
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">Game</th>

                </tr>
                </thead>
                <tbody>
                {equipments.map((item)=>
                <tr>
                    <th scope="row">#</th>
                    <td>{item.game}</td>

                </tr>
                    )}

                </tbody>
            </table>
        </div>
    );
}

export default Game;