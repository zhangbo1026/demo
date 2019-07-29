import React from 'react';

import { List, Gird, Card, Button, Row, Col, Input, Icon } from 'antd';

import { connect } from 'dva';


class Joke extends React.Component {

    state = {
        title: '',
        content: '',
        id:'',
    }

    componentDidMount() {
        this.props.dispatch({
            type: 'joke/getJokes',
        })
    }


    createHandler = (e) => {
        const title = this.newTitleInput.state.value;
        const content = this.newContentInput.state.value;

        this.props.dispatch({
            type: 'joke/createJoke',
            title: title,
            content: content,
        })


    }

    deleteHandle = (e) => {
        const id = e.target.dataset.id;
        this.props.dispatch({
            type: 'joke/deleleJokeById',
            id: id
        })

    }

    /**
     *编辑
     *
     * @memberof Joke
     */
    editHandle = (item) => {
        // const id = e.target.dataset.id;
        // this.props.dispatch({
        //     type: 'joke/getJokeById',
        //     id: id
        // })
        this.setState({
            title: item.title,
            content: item.content,
            id:item.id,
        })
    }

    /**
     *更新
     *
     * @memberof Joke
     */
    updateHandle = (e) => {
        const title = this.state.title;
        const content = this.state.content;
        const id = this.state.id;

        this.props.dispatch({
            type: 'joke/updateJokeById',
            id: id,
            title: title,
            content: content,
        })
    }

    handleTitle = (e) => {
        this.setState({
            title: e.target.value
        })
    }

    handleContent = (e) => {
        this.setState({
            content: e.target.value
        })
    }

    render() {
        return (
            <div>
                <div>
                    <Row>
                        <Col span={12}>
                            <Input placeholder="标题" ref={ref => this.newTitleInput = ref} />
                            <Input placeholder="内容" ref={ref => this.newContentInput = ref} />
                            <Button onClick={this.createHandler}>创建</Button>
                        </Col>
                        <Col span={12}>
                            <Input placeholder="标题" value={this.state.title} onChange={(e) => this.handleTitle(e)} />
                            <Input placeholder="内容" value={this.state.content} onChange={(e) => this.handleContent(e)} />
                            <Button onClick={this.updateHandle} >保存</Button>
                        </Col>
                    </Row>
                </div>
                <List
                    grid={{
                        gutter: 16,
                        xs: 1,
                        sm: 2,
                        md: 4,
                        lg: 4,
                        xl: 6,
                        xxl: 3,
                    }}
                    dataSource={this.props.joke.list}
                    renderItem={item => (
                        <List.Item>
                            <Card >
                                {item.title}
                                <br />
                                {item.content}
                                <br />

                                <Button icon="delete" onClick={this.deleteHandle} data-id={item.id}>删除</Button>
                                <Button icon="edit" onClick={() => this.editHandle(item)} data-id={item.id}>编辑</Button>
                            </Card>
                        </List.Item>
                    )}
                />

            </div>
        )
    }
}



export default connect(({ joke }) => ({
    joke
}))(Joke)