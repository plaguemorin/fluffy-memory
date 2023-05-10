
const rollButtons = document.querySelectorAll('button[data-roll-rating]');
rollButtons.forEach((buttonElement) => {
    // For each rollButton, make sure it's valid
    const ratingValue = buttonElement.getAttribute('data-roll-rating');
    if ("" + parseInt(ratingValue) !== ratingValue) {
        console.error("Expected a number in element data-roll-rating but got ", ratingValue);
        return;
    }

    // Get what we're supposed to replace
    const replaceQuery = buttonElement.getAttribute('data-roll-replace');
    const replaceQueryResult = document.querySelectorAll(replaceQuery);
    if (replaceQueryResult.length !== 1) {
        console.error("Expected only 1 element to replace in ", replaceQuery);
        return;
    }

    // This is what we're gonna replace
    const replaceElement = replaceQueryResult.item(0);
    buttonElement.addEventListener('click', (e) => {

    });
});
