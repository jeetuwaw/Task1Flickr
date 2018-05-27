package task.home.com.task1.Parser;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import task.home.com.task1.Utils.Utils;
import task.home.com.task1.models.Author;
import task.home.com.task1.models.Category;
import task.home.com.task1.models.Content;
import task.home.com.task1.models.Entry;
import task.home.com.task1.models.Feed;
import task.home.com.task1.models.FlickrModel;
import task.home.com.task1.models.Generator;
import task.home.com.task1.models.Link;

@SuppressWarnings({"FieldCanBeLocal", "CanBeFinal"})
public class FlickrXmlParser extends DefaultHandler {
    private String tmpValue;
    private FlickrModel model;
    private Link link;
    private Entry entry;
    private ArrayList<Link> linksList = new ArrayList<>();
    private ArrayList<Entry> entriesList = new ArrayList<>();
    private Feed feed;
    private Generator generator;
    private Content contents;
    private Author authors;
    private Category category;

    public FlickrXmlParser(InputStream inputStream) {
        parseDocument(inputStream);
    }


    private void parseDocument(InputStream inputStream) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = factory.newSAXParser();
            parser.parse(inputStream, this);
        } catch (ParserConfigurationException e) {
            System.out.println("ParserConfig error");
        } catch (SAXException e) {
            System.out.println("SAXException : xml not well formed");
        } catch (IOException e) {
            System.out.println("IO error");
        }

    }


    @Override
    public void startElement(String s, String s1, String elementName, Attributes attributes) {
        tmpValue = "";
        if (elementName.equalsIgnoreCase(Utils.FEED)) {
            model = new FlickrModel();
            feed = new Feed();
            model.setFeed(feed);
        } else if (elementName.equalsIgnoreCase(Utils.LINK)) {
            link = new Link();
            for (int i = 0; i < attributes.getLength(); i++) {
                String attrName = attributes.getQName(i);
                String attrValue = attributes.getValue(i);
                if (attrName.equalsIgnoreCase(Utils.REL)) {
                    link.setRel(attrValue);
                } else if (attrName.equalsIgnoreCase(Utils.TYPE)) {
                    link.setType(attrValue);
                } else if (attrName.equalsIgnoreCase(Utils.HREF)) {
                    link.setHref(attrValue);
                }
            }
        } else if (elementName.equalsIgnoreCase(Utils.ENTRY)) {
            entry = new Entry();
        } else if (elementName.equalsIgnoreCase(Utils.GENERATOR)) {
            generator = new Generator();
        } else if (elementName.equalsIgnoreCase(Utils.CONTENTS)) {
            contents = new Content();
        } else if (elementName.equalsIgnoreCase(Utils.AUTHORS)) {
            authors = new Author();
        } else if (elementName.equalsIgnoreCase(Utils.CATEGORYS)) {
            category = new Category();
        }


    }


    @Override
    public void endElement(String s, String s1, String element) {
        // if end of book element add to list
        if (element.equals(Utils.FEED)) {
            linksList.add(link);
            model.getFeed().setLink(linksList);

            model.getFeed().setGenerator(generator);
        }
        if (element.equalsIgnoreCase(Utils.ID)) {
            model.getFeed().setId(tmpValue);
            if (entry != null) {
                entry.setId(tmpValue);
            }
        }
        if (element.equalsIgnoreCase(Utils.ICON)) {
            model.getFeed().setIcon(tmpValue);
        }
        if (element.equalsIgnoreCase(Utils.UPDATED)) {
            model.getFeed().setUpdated(tmpValue);
        }
        if (element.equalsIgnoreCase(Utils.TITLE)) {
            model.getFeed().setTitle(tmpValue);
            if (entry != null) {
                entry.setTitle(tmpValue);
            }
        }
        if (element.equalsIgnoreCase(Utils.SUBTITLE)) {
            model.getFeed().setSubtitle(tmpValue);
        }
        if (element.equalsIgnoreCase(Utils.ENTRY)) {
            entriesList.add(entry);
            model.getFeed().setEntry(entriesList);
        }
        if (element.equalsIgnoreCase(Utils.CONTENTS)) {
            contents.setContent(tmpValue);
            entry.setContent(contents);
        }
        if (element.equalsIgnoreCase(Utils.AUTHORS)) {
            entry.setAuthor(authors);
        }
        if (element.equalsIgnoreCase(Utils.GENERATOR)) {
            generator.setContent(tmpValue);
            model.getFeed().setGenerator(generator);
        }
        if (element.equalsIgnoreCase(Utils.PUBLISHED)) {
            entry.setPublished(tmpValue);
        }
        if (element.equalsIgnoreCase(Utils.FLICKER_DATE_TAKEN)) {
            entry.setFlickrDateTaken(tmpValue);
        }
        if (element.equalsIgnoreCase(Utils.DC_DATE_TAKEN)) {
            entry.setDcDateTaken(tmpValue);
        }
        if (element.equalsIgnoreCase(Utils.NAME)) {
            authors.setName(tmpValue);
        }
        if (element.equalsIgnoreCase(Utils.URI)) {
            authors.setUri(tmpValue);
        }
        if (element.equalsIgnoreCase(Utils.NSID)) {
            authors.setNsID(tmpValue);
        }
        if (element.equalsIgnoreCase(Utils.BUDDYICON)) {
            authors.setFlickrBuddyicon(tmpValue);
        }
        if (element.equalsIgnoreCase(Utils.CATEGORYS)) {
            entry.setCategory(category);
        }
        if (element.equalsIgnoreCase(Utils.DISPLAYCATEGORIES)) {
            entry.setDisplaycategories(tmpValue);
        }
        if (element.equalsIgnoreCase(Utils.LINK)) {
            if (entry != null) {
                linksList.add(link);
                entry.setLink(linksList);
            }
        }
    }

    @Override
    public void characters(char[] ac, int i, int j) {
        tmpValue = new String(ac, i, j);
    }


    public FlickrModel getListOfModels() {
        return model;
    }
}