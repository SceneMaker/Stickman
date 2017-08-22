package de.dfki.common;

import de.dfki.common.agent.IAgent;
import de.dfki.common.enums.Gender;
import de.dfki.common.interfaces.AgentStage;
import de.dfki.common.interfaces.StageRoom;
import de.dfki.common.util.Names;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by alvaro on 9/12/16. Manage StickmanSwing on the Stage
 */
public abstract class AgentsOnStage
{

    public static final float DEFAULT_SCALE = 1.0f;
    protected AgentStage agentStage;
    protected String identifier;
    private Map<String, IAgent> agentsOnStage = new HashMap<>();
    private StageRoom stageRoom;
    private String mFilePath;

    public AgentsOnStage(AgentStage agentStage)
    {
        this.agentStage = agentStage;
    }

    public AgentsOnStage(AgentStage agentStage, StageRoom stageRoom)
    {
        this.agentStage = agentStage;
        this.stageRoom = stageRoom;
    }

    public AgentStage getAgentStage()
    {
        return agentStage;
    }

    public StageRoom getStageRoom()
    {
        return stageRoom;
    }

    public void setStageRoom(StageRoom stageRoom)
    {
        this.stageRoom = stageRoom;
    }

    public void addAgent(String name, boolean fullScreen)
    {
        Gender.TYPE gender = getAgentGender(name);
        addAgent(name, gender, fullScreen);
    }

    public Gender.TYPE getAgentGender(String name)
    {
        Gender.TYPE gender;
        if (Names.sFemaleNames.contains(name.toLowerCase()))
        {
            gender = Gender.TYPE.FEMALE;
        } else
        {
            gender = Gender.TYPE.MALE;
        }
        return gender;
    }

    public void addAgent(String name, Gender.TYPE gender, boolean fullScreen)
    {
        if (!agentsOnStage.containsKey(name.toLowerCase()))
        {
            addAgentToStage(name, fullScreen, gender, false);
        }
    }

    public void addAgent(String name, boolean fullScreen, boolean onlyFace)
    {
        Gender.TYPE gender = getAgentGender(name);
        if (!agentsOnStage.containsKey(name.toLowerCase()))
        {
            addAgentToStage(name, fullScreen, gender, onlyFace);
        }
    }

    public void showAgentName(boolean show)
    {
        for (IAgent s : agentsOnStage.values())
        {
            s.setShowName(show);
        }
    }

    protected abstract void addAgentToStage(String name, boolean fullScreen, Gender.TYPE gender);

    protected abstract void addAgentToStage(String name, boolean fullScreen, Gender.TYPE gender, boolean onlyFace);

    public abstract XmlTransform getXmlTransform();

    public IAgent getAgent(String name)
    {
        if (agentsOnStage.containsKey(name.toLowerCase()))
        {
            return agentsOnStage.get(name.toLowerCase());
        }
        throw new NullPointerException("No agent with name " + name);

    }

    public void clearStage()
    {
        Set<String> deleteAgent = new HashSet<>();
        agentsOnStage.keySet().stream().map((s) ->
        {
            deleteAgent.add(s);
            return s;
        }).forEach((s) -> getAgent(s).endAnimationScheduler());
    }

    protected void putFullAgentOnStage(String name, IAgent agent)
    {
        agentsOnStage.put(name.toLowerCase(), agent);
        agent.setStageRoom(stageRoom);
    }

    public Set<String> getAgentNames()
    {
        return agentsOnStage.keySet();
    }

    public IAgent getAgentByKey(String key)
    {
        return agentsOnStage.get(key);
    }

    public String getFilePath()
    {
        return mFilePath;
    }

    public void setFilePath(String mFilePath)
    {
        this.mFilePath = mFilePath;
    }

}
