import request from '@/utils/request'

export function specialtyList(data) {
    return request({
        url: '/specialty/list',
        method: 'post',
        data
    })
}

export function specialtyAdd(data) {
    console.log(data)
    return request({
        url: '/specialty/add',
        method: 'post',
        data
    })
}

export function specialtyDelete(id) {
    return request({
        url: '/specialty/delete',
        method: 'get',
        params: { id }
    })
}

export function specialtyGet(id) {
    return request({
        url: '/specialty/get',
        method: 'get',
        params: { id }
    })
}


export function specialtyUpdate(data) {
    console.log("update" , data)
    return request({
        url: '/specialty/update',
        method: 'post',
        data
    })
}
