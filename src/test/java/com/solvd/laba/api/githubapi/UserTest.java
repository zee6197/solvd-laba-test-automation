package com.solvd.laba.api.githubapi;

import com.solvd.laba.api.githubapi.domain.User;
import com.solvd.laba.api.githubapi.controller.GetUserByUsername;
import com.zebrunner.carina.api.apitools.validation.JsonComparatorContext;
import com.zebrunner.carina.api.http.HttpResponseStatusType;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeParseException;

public class UserTest {
    @DataProvider(name = "userNames")
    public Object[][] userNames() {
        return new Object[][]{
                {"brutskov", "Bahdan", "Rutskou", "Solvd Inc."},
        };
    }

    @Test(description = "verifies users", dataProvider = "userNames")
    public void verifyGetUserByUserNameTest(String userName, String firstName, String lastName, String company) {
        User user = new User();
        user.setUsername(userName);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setCompany(company);
        GetUserByUsername getUserByUsername = new GetUserByUsername(user.getUsername());
        getUserByUsername.addProperty("user", user);
        getUserByUsername.expectResponseStatus(HttpResponseStatusType.OK_200);
        getUserByUsername.callAPI();
        JsonComparatorContext comparatorContext = JsonComparatorContext.context()
                .<String>withPredicate("datePredicate", date -> isDateValid(date) &&
                        ZonedDateTime.parse(date)
                                .isAfter(LocalDate.of(2000, 1, 1)
                                        .atStartOfDay(ZoneId.systemDefault())));

        getUserByUsername.validateResponse(comparatorContext);

    }

    private static boolean isDateValid(String date) {
        try {
            ZonedDateTime.parse(date);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }
}
