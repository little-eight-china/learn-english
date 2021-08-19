import request from '@/utils/request'
import store from '@/store/index';

const backendUrl = '/dictionary';
// const backendUrl = store.state.backendUrl + '/dictionary';

// 获取单词列表
export function getDictionaryList(dictionarySpell, size) {
    console.log(store.state.backendUrl)
    return request({
        url: backendUrl + `/list?dictionarySpell=${dictionarySpell}&size=${size}`,
        method: 'get'
    })
}

