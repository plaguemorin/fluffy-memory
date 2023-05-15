document.querySelectorAll('[role="dialog"]').forEach(value => {
    value.addEventListener('show.bs.modal', event => {
        const buttonElement = event.relatedTarget;
        const url = buttonElement.getAttribute('href');

        if (url !== "" && url !== null) {
            const modalData = value
                .querySelector('div.modal-content');

            fetch(url)
                .then(res => res.text())
                .then(html => {
                    modalData.innerHTML = html;
                });
        }
    });
})


document.querySelectorAll('[data-an-toggle="remoteModal"]').forEach(value => {
    value.addEventListener('click', evt => {
        const href = evt.target.getAttribute('href');
        if (href === null || href === '') {
            return;
        }

        fetch(href)
            .then(res => res.text())
            .then(html => console.log(html));
    });
});
