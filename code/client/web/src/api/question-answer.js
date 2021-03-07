import request from '@/utils/request'

export function questionAnswerList() {
    return request({
        url: '/question-answer/list',
        method: 'get',
        // params: query
    })
}

export function questionAnswerAdd(data) {
    console.log(data)
    return request({
        url: '/question-answer/add',
        method: 'post',
        data
    })
}

export function questionAnswerDelete(id) {
    return request({
        url: '/question-answer/delete',
        method: 'get',
        params: { id }
    })
}

export function questionAnswerGet(id) {
    return request({
        url: '/question-answer/get',
        method: 'get',
        params: { id }
    })
}


export function questionAnswerUpdate(data) {
    console.log("update" , data)
    return request({
        url: '/question-answer/update',
        method: 'post',
        data
    })
}
