import React, {useEffect, useState} from 'react';




function Platform() {
    const [equipments, setEquipments] = useState([])
    const [equipments2, setEquipments2] = useState([])
    function refresh() {
        const url = 'http://localhost:8080/API/platforms';//api url
        fetch(url).then(resp => resp.json())//calling url by method GET
            .then(resp => setEquipments(resp))//setting response to state overtime
            .catch(e => console.log('There is an issue with getting the information' , e))
    }
    function awards() {
        const url = 'http://localhost:8080/API/awards';//api url
        fetch(url).then(resp => resp.json())//calling url by method GET
            .then(resp => setEquipments2(resp))//setting response to state overtime
            .catch(e => console.log('There is an issue with getting the information' , e))
    }
    useEffect(()=>{refresh();awards()},[]);
    return (
        <div>
            <h1 style={{color: "darkblue"}}>Platforms</h1>

            <br/>

            <table className="table">
                <thead className="thead-dark">
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">Platform</th>

                </tr>
                </thead>
                <tbody>
                {equipments.map((item) =>
                    <tr>
                        <th scope="row">#</th>
                        <td>{item.game}</td>

                    </tr>
                )}

                </tbody>
            </table>
            <div>
                <h1 style={{color: "darkblue"}}>Awards</h1>

                <br/>

                <table className="table">
                    <thead className="thead-dark">
                    <tr>
                        <th scope="col">#</th>
                        <th scope="col">Platform</th>

                    </tr>
                    </thead>
                    <tbody>
                    {equipments2.map((item) =>
                        <tr>
                            <th scope="row">#</th>
                            <td>{item.game}</td>

                        </tr>
                    )}

                    </tbody>
                </table>
            </div>
        </div>

    );
}

export default Platform;