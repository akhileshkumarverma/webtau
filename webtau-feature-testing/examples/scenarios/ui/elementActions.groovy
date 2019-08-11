package scenarios.ui

import static com.twosigma.webtau.WebTauGroovyDsl.*

scenario('open browser') {
    browser.open('/element-actions')
}

scenario('move to') {
    $('.menu').moveTo()
}

scenario('click on menu drop down') {
    def payments = $('.dropdown .item').get('Payments')
    payments.waitTo beVisible()
    payments.click()

    $('.messages .message').should == 'fetching payments'
}
