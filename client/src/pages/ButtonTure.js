import React from 'react';
import { Button } from 'antd'
import { connect } from 'dva';
import { statement } from '@babel/template';

var count = 1;

const mapStateToProps = (state) => {

    return {
        name: state.text.name,
    }
}

const mapDispatchToProps = (dispatch) => {
    return {
        dispatch: dispatch,
    }
}

@connect(mapStateToProps, mapDispatchToProps)
export class MyButtonWrapper extends React.Component {
    constructor(props) {
        super(props)
    }
    render() {
        return (
            <Button>{this.props.name}</Button>
        )

    }
}



const mapStateToProps2 = (state) => {

    return {
        state: state,
    }
}

const mapDispatchToProps2 = (dispatch) => {
    return {
        dispatch: dispatch,
        update: () => {
            count = count + 1;
            dispatch({
                type: 'text/fetchText',
                payload: {
                    name: count,
                }
            })
        }
    }
}
@connect(mapStateToProps2, mapDispatchToProps2)
class ButtonTure extends React.Component {

    render() {
        const { update } = this.props;
        return (
            <Button onClick={update}>click me</Button>

        )
    }
}

export default ButtonTure;