var data = []

export default {
    // 'GET /api/jokes': (req, res) => {
    //     res.send(data);
    // },
    'GET /api/jokes1': (req, res) => {
        const id = req.query.id;
        if (id) {
            data = data.filter(joke => joke.id == id);
            let newData = { title: data[0].title, content: data[0].content, id: data[0].id };
            res.send(newData);
        } else {
            res.send(data);
        }
    },


    'POST /api/jokes1': (req, res) => {

        const newData = {
            ...req.body,
            id: "joke=" + Math.random()
        };

        data.push(newData);
        res.send(data);


    },

    'PUT /api/jokes1': (req, res) => {

        const id = req.body.id;

        data.map((item) =>{
            if(item.id ===id){
                item.title=req.body.title;
                item.content=req.body.content
            }
        })

        console.log(data);
        res.send(data);


    },

    'DELETE /api/jokes1': (req, res) => {
        const id = req.query.id;
        data = data.filter(joke => joke.id !== id);
        res.send(data);
    }
}