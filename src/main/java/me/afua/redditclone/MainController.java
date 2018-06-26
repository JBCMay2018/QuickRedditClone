package me.afua.redditclone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

@Controller
public class MainController {
    @Autowired
    PageRepository pages;

    @RequestMapping("/")
    public @ResponseBody String showPages()
    {
//       Check to makes sure links are beings saved
        StringBuilder s = new StringBuilder();
        return pages.findAll().toString()+"<br/>";
    }

    //Always test to make sure your methods work
    @RequestMapping("/addpage")
    public String addPage()
    {
    //      Save test links
        Page p = new Page();
        p.setSubmitted();
        p.setUrl("http://www.google.com");
        p.setTitle("The best search engine in the world");
        p.setPostedBy("Someone Other than Someone");

        pages.save(p);


        //      Test more than one link
         p = new Page();
        p.setSubmitted();
        p.setUrl("http://www.bing.com");
        p.setTitle("Another search engine");
        p.setPostedBy("Someone Else");
        pages.save(p);


        //      Test a final ink
        p = new Page();
        p.setSubmitted();
        p.setUrl("http://www.afua.me");
        p.setTitle("Does this work for more than one link?");
        p.setImage("https://images.unsplash.com/photo-1519627398411-c86cd6daf9ac?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=5cf2e649c693208001bf3f887c9ae736&auto=format&fit=crop&w=2132&q=80");
        p.setPostedBy("Someone");
        pages.save(p);
        return "redirect:/";
    }

    //    Add method - you are already familiar with this! There's something new in the HTML form. Have a look!
    @RequestMapping("/add")
    public String addPage(Model model)
    {
        model.addAttribute("aPage",new Page());
        return "add";
    }

    //Save method - there's something new in here...have a look!
    @RequestMapping("/savepage")
    public String savePage(@ModelAttribute("aPage") Page thePage, Model model)
    {

        thePage.setSubmitted();
        pages.save(thePage);
        return "redirect:/";
    }

    //Display the links - see how it's done on the HTML page
    @RequestMapping("/renderlinks")
    public String showLinks(Model model)
    {
        model.addAttribute("pagelist",pages.findAllByOrderBySubmittedDesc());
        return "index";
    }

    @RequestMapping("/update")
    public String updatePage(HttpServletRequest request, Model model)
    {
        System.out.println(request.getParameter("id")+" is the ID");
        model.addAttribute("aPage",pages.findById(new Long(request.getParameter("id"))));
        return "add";
    }
}
