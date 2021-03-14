import request from '@/utils/request'

export function electiveCourseList(data) {
    return request({
        url: '/elective-course/list',
        method: 'post',
        data
    })
}


export function electiveCourseAdd(data) {
    console.log(data)
    return request({
        url: '/elective-course/add',
        method: 'post',
        data
    })
}

export function electiveCourseDelete(id) {
    return request({
        url: '/elective-course/delete',
        method: 'get',
        params: { id }
    })
}

export function gradeGet(id) {
    return request({
        url: '/elective-course/get',
        method: 'get',
        params: { id }
    })
}


export function gradeUpdate(data) {
    console.log("update", data)
    return request({
        url: '/elective-course/update',
        method: 'post',
        data
    })
}
