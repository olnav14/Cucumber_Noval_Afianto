Feature: Login ke Swag Labs

  Scenario: User login Succes
    Given User masuk ke halaman login
    When User mamasukan username valid
    And User memasukan password valid
    And User klik Login
    Then User berhasil Login

  Scenario: User login Failed
    Given User masuk ke halaman login
    When User mamasukan username unvalid
    And User memasukan password unvalid
    And User klik Login
    Then User gagal Login

