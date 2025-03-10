import express from 'express'
import mongoose from 'mongoose'


const app = express()

app.use(express.json())

mongoose.connect('mongodb://localhost:27017/test')
.then(() => console.log('MongoDB connected...'))
.catch(err => console.log(err))

app.listen(3000, () => console.log('Server started on port 3000'))


app.get('/faculty', async (req, res) => {
    const data = await mongoose.model('faculty','curd-angular','crud').find()
    res.send(data)
    console.log(data)
})