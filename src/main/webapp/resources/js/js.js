/**
 * Клик по кнопке "Добавить" на форме добавления нового правонарушения.
 */
$('#btn_add').on("click", function () {
    if (validate()) {
        $('#frm').submit();
    }
});

/**
 * Проверка на то, чтобы все поля на форме были заполнены.
 * @returns {boolean}
 */
function validate() {
    let rsl = true;
    let elements = document.querySelectorAll('input, textarea');
    for (let i = 0; i < elements.length; i++) {
        if (elements[i].value === "") {
            rsl = false;
            alert('Вы не заполнили поле: ' + $(elements[i]).attr('name'));
            break;
        }
    }
    return rsl;
}