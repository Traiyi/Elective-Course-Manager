import request from '@/utils/request'

export function gradeList() {
    return request({
        url: '/grade/list',
        method: 'get',
        // params: query
    })
}

export function gradeAdd(data) {
    console.log(data)
    return request({
        url: '/grade/add',
        method: 'post',
        data
    })
}

export function gradeDelete(id) {
    return request({
        url: '/grade/delete',
        method: 'get',
        params: { id }
    })
}

export function gradeGet(id) {
    return request({
        url: '/grade/get',
        method: 'get',
        params: { id }
    })
}


export function gradeUpdate(data) {
    console.log("update" , data)
    return request({
        url: '/grade/update',
        method: 'post',
        data
    })
}
