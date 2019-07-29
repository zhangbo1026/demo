import React from 'react';
import { Button } from 'antd';
import ButtonTure, { MyButtonWrapper } from './ButtonTure';
import { connect } from 'dva';


export default class Tomo extends React.Component {

    state = {
        name: 'helloword!',
        num: 0,
    }


    handleButton = () => {
        this.setState({
            num: this.state.num + 1,
        })
    }
    render() {
        return (
            <div>
                {/* <Button onClick={this.handleButton}>{this.state.num}</Button> */}
                <ButtonTure />
                <MyButtonWrapper />
            </div>
        )
    }
}