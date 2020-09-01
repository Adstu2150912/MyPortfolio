page.1442938116.10 {
    layoutRootPaths.site_hrm = EXT:site_reports/Resources/Private/Layouts/Page/
    partialRootPaths.site_hrm = EXT:site_reports/Resources/Private/Partials/Page/

    variables {
        siteRootUid = TEXT
        siteRootUid.value = {$config.site_reports.siteRootUid}

        username = TEXT
        username.data = TSFE:fe_user|user|name
    }
}

page.includeCSS {
    bootstrap = EXT:site_reports/Resources/Public/Styles/vendor/bootstrap.min.css
    fontawesome = EXT:site_reports/Resources/Public/Styles/vendor/font-awesome/css/font-awesome.min.css
    animate = EXT:site_reports/Resources/Public/Styles/vendor/animate.css
    datepicker = EXT:site_reports/Resources/Public/Styles/vendor/datepicker3.css
    reports = EXT:site_reports/Resources/Public/Styles/Style.css
}

page.includeJSFooterlibs {
    jQuery = EXT:site_reports/Resources/Public/Javascripts/vendor/jquery-2.1.1.js
    bootstrap = EXT:site_reports/Resources/Public/Javascripts/vendor/bootstrap.min.js
}

page.includeJSFooter {
    Datepicker = EXT:site_reports/Resources/Public/Javascripts/vendor/bootstrap-datepicker.js
    DatepickerNl = EXT:site_reports/Resources/Public/Javascripts/vendor/bootstrap-datepicker.nl.js
    FilterHours = EXT:site_reports/Resources/Public/Javascripts/FilterHours.js
}

page.bodyTagCObject.10 {
    40 = TEXT
    40.value = top-navigation
    40.noTrimWrap = | ||
}

[globalVar = TSFE:page|backend_layout = MaxServ.LayoutProvider__site_reports.2-Login ]
    page.bodyTagCObject.10.40.value = gray-bg
[global]