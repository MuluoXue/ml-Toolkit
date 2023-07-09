
window.form = {
    apiUrl: {
        save: "/form/save",
        list: "/form/list",
        deleteById: '/form/deleteById'
    },
    htmlUrl: {
        addForm: "/static/page/form/addForm.html"
    },
    field: {
        apiUrl: {
            save: "/form/field/save",
            list: '/form/field/list'
        },
        htmlUrl: {
            list: "/static/page/form/field/fieldList.html",
            addField: "/static/page/form/field/addField.html"
        }
    },
    data: {
        apiUrl: {
            save: '/form/data/save',
            list: '/form/data/list',
            deleteByIds: '/form/data/deleteByIds',
            findFormDataAndField: '/form/data/findFormDataAndField'
        },
        htmlUrl: {
            list: '/static/page/form/data/dataList.html',
            addFormData: '/static/page/form/data/addFormData.html'
        }
    }
}

window.user = {
    register: {
        apiUrl: {
            register: '/sys/user/register'
        }
    }
}

window.validatorMsg = {
    "code": "zh-CN",
    "message": {
    "required": "{#field}不能为空",
        "email": "{#field}不是一个有效的邮箱",
        "length": "{#field}长度必须为{length}",
        "min": "{#field}不能小于{min}",
        "max": "{#field}不能大于{max}",
        "number": "{#field}只能包含数字",
        "integer": "{#field}不是一个整数",
        "float": "{#field}不是一个浮点数",
        "between": "{#field}必须在{min}与{max}之间",
        "confirmed": "{#field}与{target}不匹配",
        "alpha": "{#field}只能包含字母字符",
        "alpha_num": "{#field}只能包含字母数字字符",
        "alpha_spaces": "{#field}只能包含字母字符和空格",
        "url": "{#field}不是合格的 URL"
}
}