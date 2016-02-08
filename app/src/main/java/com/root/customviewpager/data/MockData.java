package com.root.customviewpager.data;

import com.root.customviewpager.data.model.Word;

import java.util.ArrayList;
import java.util.List;

public class MockData {

    public List<Word> getStartWords() {
        List<Word> startWordList = new ArrayList<>();
        startWordList.add(0, new Word("accelerator", "акселлератор, (досл. ускоритель)",
                "Startup accelerators, now fixtures of the tech community, were hard to find just a few years ago.",
                "The Citrix Startup Accelerator cultivates breakthrough mobile, cloud and collaboration technologies."));

        startWordList.add(1, new Word("Alpha (version)", "альфа-версия продукта (стадия разработки ПО)",
                "Alpha version describes a development status that usually means the first complete version of a program or application.",
                "Alpha version comes after pre-alpha version and before a beta version."));

        startWordList.add(2, new Word("app", "приложение",
                "Some apps are available in versions for several different platforms.",
                "Building your first mobile app can be a challenging experience."));

        startWordList.add(3, new Word("attend a seminar/conference", "участвовать в семинаре/конференции",
                "Attending this seminar will give you great opportunities to learn more about becoming a franchise owner.",
                "Startups should attend conferences to learn the skill of the pitch."));

        startWordList.add(4, new Word("automation", "автоматизация",
                "This automation will greatly reduce the manual editing that might be still required. ",
                "The problem is that the same degree of automation is also required for quality assurance."));

        startWordList.add(5, new Word("B2B (business-to-business)", "бизнес для бизнеса",
                "You should always try and do things correctly when doing a B2B deal so that you can do more with them in the future.",
                "The B2B relationship was complimentary as each business was able to advertise for each other so they both could grow."));

        startWordList.add(6, new Word("B2C (business-to-consumer)", "бизнес для потребителя",
                "You need to try and make sure that any B2C goes well so that your customers will want to come back.",
                "The B2C transactions were increasing in frequency so we had to update the web application software we use for our payment processor."));

        startWordList.add(7, new Word("background", "прошлое (в контексте: чем вы занимались до разработки этого продукта?)",
                "Judges often ask about startup's background during the pitches.",
                "Sometimes it is important for investors to know about startup founder's background."));

        startWordList.add(8, new Word("Beta (version)", "бета-версия продукта (стадия разработки ПО)",
                "Beta software is an updated version of an existing program designed to fix some particular problem.",
                "Sometimes beta versions are released only to a select group of people."));

        startWordList.add(9, new Word("big data", "большие данные",
                "Accuracy in big data may lead to more confident decision making.",
                "One of the major problems encountered in storing big data is a rational choice of storage service."));

        startWordList.add(10, new Word("birthplace", "родина (место зарождение стартапа)",
                "Birthplace of Google Inc. is San Francisco, CA, USA.",
                "San Antonio is the birthplace of cybersecurity, but it's also a place where few startups are born."));

        startWordList.add(11, new Word("borrowed funds", "заемные средства",
                "Borrowed funds is one of the most common sources of funding for a small business.",
                "Borrowing funds from friends and family is a tried and tested option, but they should only invest money they can afford to lose."));

        startWordList.add(12, new Word("budget", "бюджет",
                "Thoughtful startup budget is the key to success.",
                "A realistic startup budget should only include those things that are necessary to start a business."));
        return startWordList;
    }
}
