import request from '@/utils/request'

export function electiveCourseList() {
    return request({
        url: '/elective-course/list',
        method: 'get',
        // params: query
    })
}


export function electiveCourseListAll() {
    return request({
        url: '/elective-course/list-all',
        method: 'get',
        // params: query
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
