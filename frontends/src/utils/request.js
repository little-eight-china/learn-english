import axios from 'axios'
import {ElMessage } from 'element-plus'

const axiosService = axios.create({
    withCredentials: true,
    timeout: 120000
})

axiosService.interceptors.request.use(
    config => {
        config.headers['Content-type'] = 'application/json; charset=utf-8'
        if (config.method === 'get') {
          config.data = true
        }
        return config
    },
    error => {
        console.log || console.log(JSON.stringify(error))
        return Promise.reject(error)
    }
)

axiosService.interceptors.response.use(
    response => {
        response = response.data
        if(response.code !== '0') {
            ElMessage.error(response.message)
            return Promise.reject(response.message)
        } else {
            return response
        }
    },
    error => {
        return Promise.reject(error)
    }
)

export default axiosService
