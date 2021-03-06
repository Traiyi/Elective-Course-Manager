import request from '@/utils/request'

export function studentList(data) {
    console.log("studentListQuery",data)
    return request({
        url: '/student/list',
        method: 'post',
        data
    })
}



export function studentAdd(data) {
    console.log(data)
    return request({
        url: '/student/add',
        method: 'post',
        data
    })
}

export function studentDelete(id) {
    return request({
        url: '/student/delete',
        method: 'get',
        params: { id }
    })
}

export function studentGet(id) {
    return request({
        url: '/student/get',
        method: 'get',
        params: { id }
    })
}


export function studentUpdate(data) {
    console.log("update" , data)
    return request({
        url: '/student/update',
        method: 'post',
        data
    })
}
