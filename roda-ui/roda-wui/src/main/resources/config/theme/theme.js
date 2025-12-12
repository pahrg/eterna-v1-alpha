$(document).ready(function () {
    // getUrlParameters function based on
    // from https://stackoverflow.com/a/2880929/1483200
    var urlParams = (function () {
        var urlParams,
            match,
            pl = /\+/g,  // Regex for replacing addition symbol with a space
            search = /([^&=]+)=?([^&]*)/g,
            decode = function (s) {
                return decodeURIComponent(s.replace(pl, " "));
            },
            query = window.location.search.substring(1);

        urlParams = {};
        while (match = search.exec(query))
            urlParams[decode(match[1])] = decode(match[2]);
        return urlParams;
    })();

    // keep branding=false retrocompatibility
    if (urlParams['branding'] === 'false') {
        urlParams['branding'] = 'nobranding';
    }

    var brandingsToInsert = [];
    if ((typeof urlParams['branding']) === 'string') {
        var brandings = urlParams['branding'].split(',');
        brandings.forEach(function (branding) {
            if (/^([a-z0-9]+)$/.test(branding)) {
                brandingsToInsert.push(branding.concat(".css"));
            }
        });
    }

    var footerProcessed = false;

    var observer = new MutationObserver(function(mutations) {
        if (footerProcessed) return;

        var footer = document.querySelector('.footer');
        if (footer) {
            footerProcessed = true;
            observer.disconnect();

            brandingsToInsert.forEach(function (branding) {
                var link = document.createElement('link');
                link.rel = 'stylesheet';
                link.type = 'text/css';
                link.href = 'api/v1/theme?resource_id=' + branding;
                document.head.appendChild(link);
            });

            loadVersionInfo();
        }
    });

    observer.observe(document.body, { 
        childList: true, 
        subtree: true 
    });

    var altObserver = new MutationObserver(function() {
        $("img:not([alt])").attr('alt', 'img_alt');
    });

    var thead = document.querySelector('thead');
    if (thead) {
        altObserver.observe(thead, { 
            childList: true, 
            subtree: true 
        });
    }

    function loadVersionInfo() {
        var pathname = window.location.pathname;
        $.get(pathname + "version.json", function (data) {
            if (data && data["git.build.version"]) {
                $("div#version").append(
                    "<div style='color:rgba(255, 255, 255, 0.5);' class='built_time'>Version " +
                    data["git.build.version"] +
                    "</div>"
                );
            }
        }).fail(function() {
            console.warn("Failed to load version.json");
        });
    }
});