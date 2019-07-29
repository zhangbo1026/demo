let count = 0;

export default {
    'Get /api/text': (req,res) =>{
        count = count+1;
        res.send({
            name:count,
        });
    }
}