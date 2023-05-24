// document.querySelectorAll('[role="dialog"]').forEach(value => {
//     value.addEventListener('show.bs.modal', event => {
//         const buttonElement = event.relatedTarget;
//         const url = buttonElement.getAttribute('href');
//
//         if (url !== "" && url !== null) {
//             const modalData = value
//                 .querySelector('div.modal-content');
//
//             fetch(url)
//                 .then(res => res.text())
//                 .then(html => {
//                     modalData.innerHTML = html;
//                 });
//         }
//     });
// })

/**
 *
 * @param {number} rating
 * @param {string} idof
 */
function rollDice(rating, id) {
    const nbDice = Math.abs(rating);
    const negative = rating < 0;

    /**
     * @type {number[]}
     */
    let dice = [];

    for (let i = 0; i < nbDice; i++) {
        dice.push(Math.floor(Math.random() * 10) + 1);
    }

    const value = (negative) ? Math.min(...dice) : Math.max(...dice);
    const critSuccess = (value === 10) ? (Math.floor(Math.random() * 10) + 1) > 5 : false;
    const critFailed = (value === 1) ? (Math.floor(Math.random() * 10) + 1) <= 5 : false;
    const success = value > 5;

    const newModal = document.createElement('div');
    newModal.setAttribute('class', 'modal fade');
    newModal.setAttribute("role", "dialog");


    if (success) {
        if (critSuccess) {
            alert("Critical Success!");
        } else {
            alert("Success");
        }
    } else {
        if (critFailed) {
            alert("Critical Failure!");
        } else {
            alert("Failed");
        }
    }
}

/**
 *
 * @param {Element} element
 */
function remoteModal(element) {
    if (element.hasOwnProperty('_fmat_remote_modal')) {
        return;
    }

    element._fmat_remote_modal = true;
    element.addEventListener('click', evt => {
        const href = evt.target.getAttribute('href');
        if (href === null || href === '') {
            return;
        }

        fetch(href)
            .then(res => res.text())
            .then(html => {
                let divElement = document.createElement("div");
                divElement.innerHTML = html;
                divElement.setAttribute("class", "modal fade");
                divElement.setAttribute("role", "dialog");
                divElement.setAttribute("aria-hidden", "true");
                divElement.removeAttribute("id");
                return divElement;
            })
            .then(elem => {
                const element = document.querySelector("body").appendChild(elem);
                elem.addEventListener('hidden.bs.modal', event => {
                    document.querySelector("body").removeChild(elem);
                });

                prepareRemoteModal(elem);

                const modal = new bootstrap.Modal(elem, {});
                modal.show(evt.target);
            });
    });

}

/**
 *
 * @param {Element | Document} element
 */
function prepareRemoteModal(element) {
    element
        .querySelectorAll('[data-an-toggle="remoteModal"]')
        .forEach(value => remoteModal(value));
}

prepareRemoteModal(document);

