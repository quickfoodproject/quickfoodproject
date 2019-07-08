$('.datepicker').pickadate({
    // Strings and translations
    monthsFull: ['Janeiro', 'Fevereiro', 'Março', 'Abril', 'Maio', 'Junho', 'Julho', 'Agosto', 'Setembro', 'Outubro', 'Novembro', 'Dezembro'],
    monthsShort: ['Jan', 'Fev', 'Mar', 'Abr', 'Mai', 'Jun', 'Jul', 'Ago', 'Set', 'Out', 'Nov', 'Dez'],
    weekdaysFull: ['Domingo', 'Segunda', 'Terça', 'Quarta', 'Quinta', 'Sexta', 'Sábado'],
    weekdaysShort: ['Dom', 'Seg', 'Ter', 'Qua', 'Qui', 'Sex', 'Sáb'],
    showMonthsShort: undefined,
    showWeekdaysFull: undefined,

    // Buttons
    today: 'Hoje',
    clear: 'Excluir',
    close: 'Fechar',

    // Accessibility labels
    labelMonthNext: 'Próximo mês',
    labelMonthPrev: 'Mês anterior',
    labelMonthSelect: 'Selecione um mês',
    labelYearSelect: 'Selecione um ano',

    // Formats
    format: 'dd/mm/yy',
    formatSubmit: undefined,
    hiddenPrefix: undefined,
    hiddenSuffix: '_submit',
    hiddenName: undefined,

    // Editable input
    editable: undefined,

    // Dropdown selectors
    selectYears: 1000,
    selectMonths: undefined,

    // First day of the week
    firstDay: undefined,

    // Date limits
    min: new Date(1900, 01, 01),
    max: new Date(2050, 31, 12),


    // Disable dates
    disable: undefined,

    // Root picker container
    container: undefined,

    // Hidden input container
    containerHidden: undefined,

    // Close on a user action
    closeOnSelect: true,
    closeOnClear: true,

    // Events
    onStart: undefined,
    onRender: undefined,
    onOpen: undefined,
    onClose: undefined,
    onSet: undefined,
    onStop: undefined,

    // Classes
    class: {

        // The element states
        input: 'picker__input',
            active: 'picker__input--active',

            // The root picker and states *
            picker: 'picker',
            opened: 'picker--opened',
            focused: 'picker--focused',

            // The picker holder
            holder: 'picker__holder',

            // The picker frame, wrapper, and box
            frame: 'picker__frame',
            wrap: 'picker__wrap',
            box: 'picker__box',

            // The picker header
            header: 'picker__header',

            // Month navigation
            navPrev: 'picker__nav--prev',
            navNext: 'picker__nav--next',
            navDisabled: 'picker__nav--disabled',

            // Month & year labels
            month: 'picker__month',
            year: 'picker__year',

            // Month & year dropdowns
            selectMonth: 'picker__select--month',
            selectYear: 'picker__select--year',

            // Table of dates
            table: 'picker__table',

            // Weekday labels
            weekdays: 'picker__weekday',

            // Day states
            day: 'picker__day',
            disabled: 'picker__day--disabled',
            selected: 'picker__day--selected',
            highlighted: 'picker__day--highlighted',
            now: 'picker__day--today',
            infocus: 'picker__day--infocus',
            outfocus: 'picker__day--outfocus',

            // The picker footer
            footer: 'picker__footer',

            // Today, clear, & close buttons
            buttonClear: 'picker__button--clear',
            buttonClose: 'picker__button--close',
            buttonToday: 'picker__button--today'
    }
});
window.addEventListener('DOMContentLoaded', function() {
    (() => {
        const recBtn = document.querySelector('#btn_rec');
        const output = document.querySelector('#output');
        let recording = false;
        let transcricao = '';
        let speechRecognition = window.SpeechRecognition || window.webkitSpeechRecognition;
        const recognition = new speechRecognition();

        recognition.interimResults = false;
        recognition.lang = "pt-BR | en-US";
        recognition.continuous = true;

        recognition.onstart = function() {
            recording = true;
        };

        recognition.onend = function() {
            recording = false;
        };

        recognition.onresult = function(event) {
            transcricao = event.results[0][0].transcript;
            console.log(transcricao);
            let ss = document.querySelector('#busca');
            ss.value = transcricao;
        };

        recBtn.addEventListener('click', function(e) {
            if (recording) {
                recognition.stop();
                return;
            }
            recognition.start();
        }, false);
    })();
}, false);



$(function() {
    $('.material-tooltip-main').tooltip({
        template: '<div class="tooltip md-tooltip-main"><div class="tooltip-arrow md-arrow"></div><div class="tooltip-inner md-inner-main"></div></div>'
    });
})










// SideNav Button Initialization

$(".button-collapse").sideNav();
// SideNav Scrollbar Initialization
var sideNavScrollbar = document.querySelector('.custom-scrollbar');
var ps = new PerfectScrollbar(sideNavScrollbar);