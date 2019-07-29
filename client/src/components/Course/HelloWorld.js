import React from 'react';
import { extend } from 'umi-request';

class HelloWorld extends React.Component {

    render() {
        return (
            <div>{this.props.name}{this.props.children}</div>
        )
    }
}

export default HelloWorld;