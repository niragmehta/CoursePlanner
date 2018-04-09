package ca.coursePlanner.model;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class SectionCollection {

    private static List<Section> sectionList=new ArrayList<>();


    public static void populateSectionCollection(int courseOfferingId)
    {
        sectionList=new ArrayList<>();
        AtomicInteger atomicInteger=new AtomicInteger();
        Offering offering=OfferingCollection.getOfferingById(courseOfferingId);

        Section section= new Section();
        for(int i=0;i<offering.getComponentType().size();i++)
        {
            section.setType(offering.getComponentType().get(i));
            section.setEnrollmentTotal(offering.getComponentTotal().get(i));
            section.setEnrollmentCap(offering.getComponentCapacity().get(i));

            sectionList.add(section);
            section=new Section();

        }

    }

    public static List<Section> getSectionList() {
        return sectionList;
    }
}
