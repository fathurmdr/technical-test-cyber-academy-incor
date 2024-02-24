document.addEventListener("readystatechange", () => {
    const lang = document.getElementById("lang");

    lang.addEventListener("change", (event) => {
        const value = event.target.value;
        if (value !== "") {
          const currentURL = window.location.origin + window.location.pathname;
          window.location.replace(currentURL + "?lang=" + value);
        }
    });
});
