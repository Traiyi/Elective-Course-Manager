import request from '@/utils/request'

export function electiveList(data) {
    return request({
        url: '/elective/list',
        method: 'post',
        data
    })
}


export function electiveListElectivePass(id) {
    return request({
        url: '/elective/list-elective-pass',
        method: 'get',
        params: { id }
    })
}

export function electiveListElectiveNoPass(id) {
    return request({
        url: '/elective/list-elective-no-pass',
        method: 'get',
        params: { id }
    })
}


export function electiveListStudent(id) {
    return request({
        url: '/elective/list-student',
        method: 'get',
        params: { id }
    })
}



export function electiveAdd(data) {
    console.log(data)
    return request({
        url: '/elective/add',
        method: 'post',
        data
    })
}

export function electiveDelete(id) {
    return request({
        url: '/elective/delete',
        method: 'get',
        params: { id }
    })
}

export function electiveGet(id) {
    return request({
        url: '/elective/get',
        method: 'get',
        params: { id }
    })
}


export function electiveUpdate(data) {
    console.log("update", data)
    return request({
        url: '/elective/update',
        method: 'post',
        data
    })
}



export function electiveTotalElective(id) {
    return request({
        url: '/elective/total-elective',
        method: 'get',
        params: { id }
    })
}
