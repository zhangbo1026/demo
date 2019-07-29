import request from '../utils/request';

export default {
    namespace: 'joke',
    state: {
        list: [],
        data: {},
    },

    reducers: {
        updateState(state, { payload }) {
            console.log(payload);
            return {
                ...state,
                list: payload,
            }
        },

        getData(state, { payload }) {
            return {
                ...state,
                data: payload
            }
        }

    },

    effects: {
        /**
         * 获取所有的joke
         * @param {*} param0 
         * @param {*} param1 
         */
        *getJokes({ payload }, { call, put }) {
            const response = yield call(request.get, '/api/jokes');
            yield put({
                type: 'updateState',
                payload: response
            })
        },

        /**
        获取指定 joke 
        */
        *getJokeById({ id }, { call, put }) {
            const response = yield call(request.get, `/api/jokes?id=${id}`);

            yield put({
                type: 'getData',
                payload: response
            })
        },

        /**
        删除指定 joke 
        */
        *deleleJokeById({ id }, { call, put }) {
            const response = yield call(request.delete, `/api/jokes/${id}`);


            yield put({
                type: 'updateState',
                payload: response
            })
        },

        /**
        更新指定 joke 
        */
        *updateJokeById({ id, title, content }, { call, put }) {
            const body = {
                id: id,
                title: title,
                content: content
            }

            const response = yield call(request.put, `/api/jokes/${id}`, {
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(body)
            });


            yield put({
                type: 'updateState',
                payload: response
            })
        },

        /**
        创建指定 joke 
        */
        *createJoke({ title, content }, { call, put }) {
            const body = {
                title: title,
                content: content
            }

            const response = yield call(request.post, '/api/jokes', {
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(body)
            });


            yield put({
                type: 'updateState',
                payload: response
            })
        }
    }
}