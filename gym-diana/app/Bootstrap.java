import play.jobs.Job;
import play.jobs.OnApplicationStart;
import play.test.Fixtures;

import java.util.List;

import play.*;
import play.jobs.*;
import play.test.*;

import models.*;

@OnApplicationStart
public class Bootstrap extends Job
{
    public void doJob()
    {
        if (Member.count() == 0)
        {
            Fixtures.loadModels("data.yml");
        }
    }
}

